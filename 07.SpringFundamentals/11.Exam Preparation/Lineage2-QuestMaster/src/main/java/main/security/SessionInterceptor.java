package main.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.model.Player;
import main.model.PlayerRole;
import main.service.PlayerService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Component
public class SessionInterceptor implements HandlerInterceptor {

    public static final Set<String> UNAUTHENTICATED_ENDPOINTS = Set.of("/login", "/register", "/", "/logout", "/error");
    public static final String USER_ID_FROM_SESSION = "playerId";
    private final PlayerService playerService;

    public SessionInterceptor(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String endpoint = request.getServletPath();
        if (UNAUTHENTICATED_ENDPOINTS.contains(endpoint)) {
            return true;
        }

        if (request.getSession(false) == null || request.getSession(false).getAttribute(USER_ID_FROM_SESSION) == null) {
            response.sendRedirect("/");
            return false;
        }

        UUID userId = (UUID) request.getSession(false).getAttribute(USER_ID_FROM_SESSION);

        Player player = playerService.getById(userId);
        boolean playerHasRole = player.getRole() != null;
        boolean endpointIsRolePage = endpoint.contains("role");

        if (playerHasRole && endpointIsRolePage) {
            response.sendRedirect("/home");
            return false;
        }

        if (!playerHasRole && !endpointIsRolePage) {
            response.sendRedirect("/role-select");
            return false;
        }

        return true;
    }
}

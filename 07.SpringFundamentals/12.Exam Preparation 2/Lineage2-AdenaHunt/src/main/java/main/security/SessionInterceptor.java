package main.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.model.Player;
import main.service.PlayerService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Set;
import java.util.UUID;

@Component
public class SessionInterceptor implements HandlerInterceptor {

    public static final Set<String> UNAUTHENTICATED_ENDPOINTS = Set.of("/login", "/register", "/", "/error");
    public static final String USER_ID_FROM_SESSION = "user_id";
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


        UUID uuid = (UUID) request.getSession(false).getAttribute(USER_ID_FROM_SESSION);

        Player player = playerService.getById(uuid);
        boolean playerHasClass = player.getPlayerClass() != null;
        boolean endpointIsClassPage = endpoint.contains("class");

        if (playerHasClass && endpointIsClassPage) {
            response.sendRedirect("/lobby");
            return false;
        }

        if (!playerHasClass && !endpointIsClassPage) {
            response.sendRedirect("/class");
            return false;
        }


        return true;
    }
}

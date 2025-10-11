package app.web;

import app.transaction.model.Transaction;
import app.transaction.service.TransactionService;
import app.user.model.User;
import app.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/transactions")
public class TransactionController {


    private final TransactionService transactionService;
    private final UserService userService;

    @Autowired
    public TransactionController(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }


    @GetMapping
    public ModelAndView getTransactionsPage(HttpSession session){

        UUID id = (UUID) session.getAttribute("userId");
        User user = userService.getById(id);
        List<Transaction> transactions = transactionService.getByUserId(user.getId());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("transactions", transactions);
        modelAndView.setViewName("transactions");

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getTransaction(@PathVariable UUID id) {

        Transaction transaction = transactionService.getById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("transaction", transaction);
        modelAndView.setViewName("transaction-result");

        return modelAndView;
    }
}

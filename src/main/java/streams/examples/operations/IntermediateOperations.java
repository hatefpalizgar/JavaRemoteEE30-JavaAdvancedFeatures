package streams.examples.operations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperations {

    public static void main(String[] args) {
        List<Payment> payments = Arrays.asList(
                new Payment("1", "John", new BigDecimal("100.50"), Payment.PaymentStatus.APPROVED, LocalDate.now()),
                new Payment("2", "Mary", new BigDecimal("200.75"), Payment.PaymentStatus.PENDING, LocalDate.now().minusDays(60)),
                new Payment("3", "John", new BigDecimal("50.00"), Payment.PaymentStatus.APPROVED, LocalDate.now()),
                new Payment("4", "Bob", new BigDecimal("150.25"), Payment.PaymentStatus.REJECTED, LocalDate.now()),
                new Payment("5", "Mary", new BigDecimal("75.00"), Payment.PaymentStatus.PENDING, LocalDate.now().minusDays(15))
        );

        // filter() to get only the approved payments
        List<Payment> approvedPayments = payments.stream()
                .filter(payment -> payment.getStatus() == Payment.PaymentStatus.APPROVED)
                .peek(System.out::println)
                .collect(Collectors.toList());

        // filter() to get only the approved payments by John
        List<Payment> approvedPaymentsByJohn = payments.stream()
                .filter(payment -> payment.getStatus() == Payment.PaymentStatus.APPROVED && payment.getCustomerName().equals("John"))
                .collect(Collectors.toList());

        // map() to transform the Payment objects into their amount
        List<BigDecimal> paymentAmounts = payments.stream()
                .map(payment -> payment.getAmount())
                .collect(Collectors.toList());

        // sorted() to sort the payments by their amount
        List<Payment> sortedPayments = payments.stream()
                .sorted(Comparator.comparing(payment -> (payment).getAmount()))
                .peek(p -> System.out.println(p))
                .collect(Collectors.toList());

        // distinct() to get the unique customer names
        List<String> uniqueCustomerNames = payments.stream()
                .map(p -> p.getCustomerName())
                .distinct()
                .collect(Collectors.toList());

        // limit() to get the first two payments made by Mary
        List<Payment> firstTwoPaymentsByMary = payments.stream()
                .filter(p -> p.getCustomerName().equals("Mary"))
//                .filter(Payment::getCustomerName)   // Method reference is not calling the method, it's just a way to tell
                // Java how to construct the lambda expression for it in terms of method signature
                // SO, IT'S NOT A METHOD INVOCATION/CALL
                .limit(2)
                .collect(Collectors.toList());

    }
}

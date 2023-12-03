package streams.examples.operations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TerminalOperations {
    public static void main(String[] args) {
        List<Payment> payments = Arrays.asList(
                new Payment("1", "John", new BigDecimal("100.50"), Payment.PaymentStatus.APPROVED, LocalDate.now()),
                new Payment("2", "Mary", new BigDecimal("200.75"), Payment.PaymentStatus.PENDING, LocalDate.now().minusDays(60)),
                new Payment("3", "John", new BigDecimal("50.00"), Payment.PaymentStatus.APPROVED, LocalDate.now()),
                new Payment("4", "Bob", new BigDecimal("150.25"), Payment.PaymentStatus.REJECTED, LocalDate.now()),
                new Payment("5", "Mary", new BigDecimal("75.00"), Payment.PaymentStatus.PENDING, LocalDate.now().minusDays(15))
        );


        // count(): this terminal operation returns the number of elements in the stream
        long count = payments.stream().count();

        System.out.println(count);

        // forEach(): this terminal operation performs an action for each element in the stream
        payments.stream().forEach(p -> System.out.println(p.getCustomerName() + ":" + p.getAmount()));
        /*
        Output:
            John:100.50
            Mary:200.75
            John:50.00
            Bob:150.25
            Mary:75.00
        */

        // max(): this terminal operation returns the maximum element of the stream, according to a given comparator
        Optional<Payment> maxPayment = payments.stream()
                .max(Comparator.comparing(Payment::getAmount));
        maxPayment.ifPresent(payment -> System.out.println("Maximum Payment" + ":" + payment));  // print payment with ID 2

        // min(): this terminal operation returns the minimum element of the stream, according to a given comparator
        // TODO

        // reduce(): this terminal operation reduces the elements of the stream to a single value, according to a given binary operator
        Optional<BigDecimal> totalAmount = payments.stream()
                .map(payment -> payment.getAmount())
                .reduce((amount1, amount2) -> amount1.add(amount2));
        totalAmount.ifPresent(amount -> System.out.println("Total amount" + ":" + amount));
    }
}

package optionals;

import java.util.Optional;

public class Main {
    public static void main1(String[] args) {

        User vipUser = new User();

        // because vipUser.getAddress() is null, you can't call any method like getCountry() on it
        // otherwise like below you'll get NPE
        // String isoCode = vipUser.getAddress().getCountry().getIsoCode();

        // so, to avoid this exception being thrown we can
        // do a null check for every single object
        if (vipUser != null) {
            Address address = vipUser.getAddress();
            if (address != null) {
                Country country = address.getCountry();
                if (country != null) {
                    String isoCode = country.getIsoCode();
                }
            }
        }

        // but the same logic above (nested null checks) can be replaced with Optionals
        String isoCode = Optional.ofNullable(vipUser.getAddress())  // Optional<Address>
                .map(address -> address.getCountry())   // Optional<Country>
                .map(country -> country.getIsoCode())  // Optional<String>
                .orElse("default");

        System.out.println(isoCode);  // "default" cause vipUser has no address


        Integer number = 5;
        // if number contains a value, optionalNumber will get the same value
        Optional<Integer> optionalNumber = Optional.ofNullable(number);
        // otherwise, if number is null, optionalNumber will become EMPTY (NOT null this time because of ofNullable)

        System.out.println(optionalNumber);  // Optional[5]
        System.out.println(optionalNumber.get());  // 5

        number = null;
        Optional<Integer> emptyOptional = Optional.ofNullable(number);
        System.out.println(emptyOptional); // Optional.empty

        // Second way of creating Optional
        // using of() method you have to be sure that its argument is a non-null object
        // Optional<Integer> someNumber = Optional.of(number);  // Throws NPE because number is null


        // How to create an empty optional using empty() method
        User user = new User();
        Optional<User> emptyOpt = Optional.empty();
        // emptyOpt.get(); // NoSuchElementException because you can't get a value from an empty optional
        emptyOpt.orElse(new User());  // orElse is a safer alternative to get()

        // How to return default value using Optionals
        User someUser = null;
        User opt = Optional.ofNullable(someUser).orElse(new User());
        System.out.println(opt);  // a new user will be printed: User{address=null}


        // We can check if an optional contains a value or not using isPresent()
        if (optionalNumber.isPresent()) {
            System.out.println(optionalNumber.get());
        } else {
            System.out.println("optionalNumber is empty");
        }


    }

    public static void main2(String[] args) {
        Player player = new Player("John", "john@gmail.com");

        // wrap any object inside an optional using either of() or ofNullable()
        Optional<Player> optionalPlayer = Optional.ofNullable(player);

        // unwrap an object inside an optional using get() / orElse()
        // orElse() is useful if you want to return a default value instead
        Player extractedPlayer = optionalPlayer.orElse(new Player("default", "default@gmail.com"));

        // check if an optional contains a value or not
        System.out.println(optionalPlayer.isPresent());  // true

        // execute a logic if an optional contains a value
        optionalPlayer.ifPresent(p -> System.out.println(p.getEmail()));

        // Transform optional variables using map()
        String email = optionalPlayer  // Optional<Player>
                .map(p -> p.getEmail())   // transformed ----> Optional<String>
                .get(); // String
        System.out.println(email);  // john@gmail.com
    }

    // flatmap()
    public static void main3(String[] args) {
        Member member = new Member("John", Optional.of("john@gmail.com"));

        Optional<Member> memberOptional = Optional.of(member);

        // map()
        Optional<Optional<String>> emailByMap = memberOptional.map(m -> m.getEmail());

        // flatMap()
        Optional<String> emailByFlatMap = memberOptional.flatMap(m -> m.getEmail());

        System.out.println(emailByFlatMap.orElse("Email not found"));

        // flatMap() is useful when you are dealing with objects that have their fields as Optional (BAD PRACTICE! you should never have your fields declared as Optional though).
        // For example, in our code, Member class has it's email field as Optional<String> rather than String.

        // You can think of flatMap() as a map() + extraction[flatten]

    }

    // filter
    public static void main(String[] args) {
        Member member = new Member("John", Optional.of("john@gmail.com"));

        Optional<Member> memberOptional = Optional.of(member);

        Optional<Member> filteredMember = memberOptional.filter(m -> m.getName().contains("J"));
        System.out.println(filteredMember.isPresent());


        /*
         * NB! Please read more about Optionals here: https://stackify.com/optional-java/
         */
    }
}

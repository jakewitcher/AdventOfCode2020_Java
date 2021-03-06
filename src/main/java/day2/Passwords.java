package day2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Passwords {
    private final List<String> passwords;
    private final Pattern pattern;

    public Passwords(List<String> passwords) {

        this.passwords = passwords;
        pattern = Pattern.compile("(\\d+)|(\\w+)");
    }

    public long countValidBySledRentalPolicy() {
        return countValidBy(SledRentalPolicy::new);
    }

    public long countValidByTobogganRentalPolicy() {
        return countValidBy(TobogganRentalPolicy::new);
    }

    private long countValidBy(PolicyCreator creator) {
        return passwords.stream().map(rawPassword -> {
            var result = parsePolicyAndPassword(creator, rawPassword);
            return result.policy.isValidPassword(result.password);
        }).filter(t -> t).count();
    }

    public ParserResult parsePolicyAndPassword(PolicyCreator creator, String input) {
        var matcher = pattern.matcher(input);
        var matches = new ArrayList<String>();

        while (matcher.find()) {
            matches.add(matcher.group());
        }

        if (matches.size() != 4) {
            throw new IllegalArgumentException();
        }

        var firstNum = Integer.parseInt(matches.get(0));
        var secondNum = Integer.parseInt(matches.get(1));
        var requiredChar = matches.get(2).charAt(0);
        var password = matches.get(3);

        var policy = creator.create(firstNum, secondNum, requiredChar);

        return new ParserResult(policy, password);
    }
}

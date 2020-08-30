package my.experiments.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRegex {


    private static final String EMAIL_REGEX_PATTERN="^[a-zA-Z0-9_.+-]?(info|user|user.name)+@(?:(?:[a-zA-Z0-9-]+.)?[a-zA-Z]+.)?(domain|devkau.ddns).(com|in|net)";

    public static void main(String [] args) {

        List<String> emails = new ArrayList();
        emails.add("user@domain.com");
        emails.add("user.name@domain.com");
        emails.add("user@domain.in");
        emails.add("user1@domain.com");
        emails.add("user.name@domain.com");
        emails.add("user1@test.com");
        emails.add("info@test.com");
        emails.add("info@devkau.ddns.net");


        //Invalid emails
        emails.add("user#@domain.in");
        emails.add("user#domain.com");
        emails.add("@yahoo.com");
        emails.add("user@domaincom");

        Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);

        for(String email : emails){
            Matcher matcher = pattern.matcher(email);
            System.out.println(email +" : "+ matcher.matches());
        }

    }
}

package regex;

/**
 * Task1 - Is in the code below.
 * Task2 - Is in the code below.
 * Task4 - Is in the code below.
 */

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegExChecker {

    /**
     * Task2: regular expression to validate
     * - e-mail
     * - IP
     * - bank card
     */
    public static final String REGEX_TEMPLATE_EMAIL = "^([\\w\\.\\-]+)(\\+\\w+)?@\\w+\\.(\\w+\\.)?\\w{3}$";
    public static final String REGEX_TEMPLATE_IP = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
    public static final String REGEX_TEMPLATE_CARD = "^(4(\\d{12}|\\d{15})|5\\d{15}|3[47]\\d{13})$";

    public static final String REGEX_TEMPLATE_URL = "^(\\w+)\\:\\/\\/([\\w\\-\\.]+)\\/([\\w\\-]+)\\/([\\w\\-]+)\\/([\\w\\-]+)$";


    /**
     * Test Data
     */
    protected static String testEmail = "test-test.test+test@email.ua.cmo";
    protected static String testIpAddress = "0.1.22.333";
    protected static String testURL = "https://www.epam.com/about/who-we-are/contact";
    protected static String testVisaCard = "4111111111111"; // Visa cards begin with a 4 and have 13 or 16 digits
    protected static String testMasterCard = "5111111111111111"; // Mastercard cards begin with a 5 and has 16 digits
    protected static String testAmExCard = "341111111111111"; // American Express cards begin with a 3, followed by a 4 or a 7 has 15 digits


    public static void main(String[] args) {

        System.out.println("\nIs the email valid?   " + testEmail);
        System.out.println(RegExChecker.isStringValidatesRegexTemplate(testEmail, REGEX_TEMPLATE_EMAIL));

        System.out.println("\nIs the IP address valid?   " + testIpAddress);
        System.out.println(RegExChecker.isStringValidatesRegexTemplate(testIpAddress, REGEX_TEMPLATE_IP));

        System.out.println("\nIs the Card number valid?");
        System.out.println(testVisaCard + "   " + RegExChecker.isStringValidatesRegexTemplate(testVisaCard, REGEX_TEMPLATE_CARD));
        System.out.println(testMasterCard + "   " + RegExChecker.isStringValidatesRegexTemplate(testMasterCard, REGEX_TEMPLATE_CARD));
        System.out.println(testAmExCard + "   " + RegExChecker.isStringValidatesRegexTemplate(testAmExCard, REGEX_TEMPLATE_CARD));

        System.out.println("\nIs the URL valid?   " + testURL);
        System.out.println(RegExChecker.isStringValidatesRegexTemplate(testURL, REGEX_TEMPLATE_URL));

        System.out.println("\nGroups of URL as text:   " + getRegexGroups(REGEX_TEMPLATE_URL, testURL));

    }

    /**
     * Task1: Boolean method to validate whether String matches regular expression
     *
     * @param strToCheck
     * @param regexTemplate
     * @return
     */
    public static boolean isStringValidatesRegexTemplate(String strToCheck, String regexTemplate) {
        return strToCheck.matches(regexTemplate);
    }

    /**
     * Task4: Get Epam address elements as text (https://www.epam.com/about/who-we-are/contact) using regex
     *
     * @param regexTemplate
     * @param stringToCheck
     * @return
     */
    public static String getRegexGroups(String regexTemplate, String stringToCheck) {

        Matcher matcher = Pattern.compile(regexTemplate).matcher(stringToCheck);

        if (matcher.find()) {

            StringJoiner joiner = new StringJoiner(", ");
            for (int i = 0; i < matcher.groupCount(); i++) {
                joiner.add(matcher.group(i + 1));
            }
            return joiner.toString();
        }
        return "no groups";
    }

}

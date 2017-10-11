package id.co.telkomsigma.etc.cbo.integration.transaction.util;

import id.co.telkomsigma.tmf.util.common.random.RegexStringGenerator;

import static id.co.telkomsigma.tmf.data.constant.TMFConstant.Common.Punctuation.HYPHEN;

/**
 * Created on 10/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class UUIDGenerator {

    public static final String REGEX_1 = "([A-F0-9]{8})([A-F0-9]{4})([A-F0-9]{4})([A-F0-9]{4})([A-F0-9]{12})";

    public static String generate(){
        String result = RegexStringGenerator.generateRegex(REGEX_1);
        result = result.substring(0, 8) + HYPHEN +
                result.substring(8, 12) + HYPHEN +
                result.substring(12, 16) + HYPHEN +
                result.substring(16, 20) + HYPHEN +
                result.substring(20, 32);
        return result;
    }

}

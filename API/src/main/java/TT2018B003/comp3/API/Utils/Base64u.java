package TT2018B003.comp3.API.Utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;


@Component
public class Base64u {
	private final static String base64chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	public Base64u() {}
	
	public String getMd5(String input) { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
	
	public String encode(String s) {
	// the result/encoded string, the padding string, and the pad count
	String r = "", p = "";
	int c = s.length() % 3;

	// add a right zero pad to make this string a multiple of 3 characters
	if (c > 0) {
	    for (; c < 3; c++) {
		p += "=";
		s += "\0";
	    }
	}

	// increment over the length of the string, three characters at a time
	for (c = 0; c < s.length(); c += 3) {

	    // we add newlines after every 76 output characters, according to
	    // the MIME specs
	    if (c > 0 && (c / 3 * 4) % 76 == 0)
		r += "\r\n";

	    // these three 8-bit (ASCII) characters become one 24-bit number
	    int n = (s.charAt(c) << 16) + (s.charAt(c + 1) << 8)
		    + (s.charAt(c + 2));

	    // this 24-bit number gets separated into four 6-bit numbers
	    int n1 = (n >> 18) & 63, n2 = (n >> 12) & 63, n3 = (n >> 6) & 63, n4 = n & 63;

	    // those four 6-bit numbers are used as indices into the base64
	    // character list
	    r += "" + base64chars.charAt(n1) + base64chars.charAt(n2)
		    + base64chars.charAt(n3) + base64chars.charAt(n4);
	}

	return r.substring(0, r.length() - p.length()) + p;
    }
    
    public String decode(String s) {

	// remove/ignore any characters not in the base64 characters list
	// or the pad character -- particularly newlines
	s = s.replaceAll("[^" + base64chars + "=]", "");

	// replace any incoming padding with a zero pad (the 'A' character is
	// zero)
	String p = (s.charAt(s.length() - 1) == '=' ? 
		(s.charAt(s.length() - 2) == '=' ? "AA" : "A") : "");
	String r = "";
	s = s.substring(0, s.length() - p.length()) + p;

	// increment over the length of this encoded string, four characters
	// at a time
	for (int c = 0; c < s.length(); c += 4) {

	    // each of these four characters represents a 6-bit index in the
	    // base64 characters list which, when concatenated, will give the
	    // 24-bit number for the original 3 characters
	    int n = (base64chars.indexOf(s.charAt(c)) << 18)
		    + (base64chars.indexOf(s.charAt(c + 1)) << 12)
		    + (base64chars.indexOf(s.charAt(c + 2)) << 6)
		    + base64chars.indexOf(s.charAt(c + 3));

	    // split the 24-bit number into the original three 8-bit (ASCII)
	    // characters
	    r += "" + (char) ((n >>> 16) & 0xFF) + (char) ((n >>> 8) & 0xFF)
		    + (char) (n & 0xFF);
	}

	// remove any zero pad that was added to make this a multiple of 24 bits
	return r.substring(0, r.length() - p.length());
    }
    
	

}

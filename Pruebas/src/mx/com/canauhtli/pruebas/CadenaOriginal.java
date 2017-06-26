package mx.com.canauhtli.pruebas;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class CadenaOriginal {

	public static void main(String[] args) throws TransformerException, IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
		String xsltsrc = "C:\\Users\\eduardo\\proyectos\\Docs\\cadenaoriginal_3_2.xslt";
		String xmlsrc = "C:\\Users\\eduardo\\proyectos\\factOut\\fp051903F1531.xml";
		File privKeyFile = new File("C:\\Users\\eduardo\\proyectos\\Docs\\Cert_Sellos\\CSD01_AAA010101AAA.key");
		TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(xsltsrc));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new File(xmlsrc));
        StringWriter sw = new StringWriter();
        transformer.transform(text, new StreamResult(sw));
        System.out.println(sw);
        
        
        DataInputStream dis = new DataInputStream(new FileInputStream(privKeyFile));
        byte[] privKeyBytes = new byte[(int)privKeyFile.length()];
        dis.read(privKeyBytes);
        dis.close();
        
        EncryptedPrivateKeyInfo encryptPKInfo = new EncryptedPrivateKeyInfo(privKeyBytes);
        Cipher cipher = Cipher.getInstance(encryptPKInfo.getAlgName());
        PBEKeySpec pbeKeySpec = new PBEKeySpec("12345678a".toCharArray());
        SecretKeyFactory secFac = SecretKeyFactory.getInstance(encryptPKInfo.getAlgName());
        Key pbeKey = secFac.generateSecret(pbeKeySpec);
        AlgorithmParameters algParams = encryptPKInfo.getAlgParameters();
        cipher.init(Cipher.DECRYPT_MODE, pbeKey, algParams);
        
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(encryptPKInfo.getKeySpec(cipher).getEncoded());
        RSAPrivateKey privKey = (RSAPrivateKey) keyFactory.generatePrivate(privSpec);
        
        System.out.println(privKey.getAlgorithm());
        
       
	}

}

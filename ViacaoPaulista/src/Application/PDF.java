package Application;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PDF {
	PDDocument invc;
	PDImageXObject pdImage;
	PDImageXObject pdImage2;
	public PDF(){
		invc = new PDDocument();
		PDPage newpage = new PDPage();
		invc.addPage(newpage);
		try {
			pdImage = PDImageXObject.createFromFile("C:\\Users\\User\\Documents\\ViacaoPaulista\\ViacaoPaulista\\src\\resources\\logo - Copia.png", invc);
			pdImage2 = PDImageXObject.createFromFile("C:\\Users\\User\\Documents\\ViacaoPaulista\\ViacaoPaulista\\src\\resources\\barcode2.png", invc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void WriteInvoice(String user, String cpf, String value) {
		PDPage mypage = invc.getPage(0);
		try {
			PDPageContentStream cs = new PDPageContentStream(invc, mypage);
			
			cs.drawImage(pdImage, 0,690);
			cs.drawImage(pdImage2, 210,150);
			cs.beginText();
			cs.setFont(PDType1Font.TIMES_ROMAN, 20);
		    cs.newLineAtOffset(250, 750);
		    cs.showText("Viação Paulista");
		    cs.endText();
		    
		    cs.beginText();
		    cs.setFont(PDType1Font.TIMES_ROMAN, 18);
		    cs.newLineAtOffset(270, 690);
		    cs.showText("Pagamento");
		    cs.endText();
		    
		  
		      cs.beginText();
		      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
		      cs.setLeading(20f);
		      cs.newLineAtOffset(60, 610);
		      cs.showText("Nome do usuário: ");
		      cs.newLine();
		      cs.showText("CPF: ");
		      cs.endText();
		      
		      cs.beginText();
		      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
		      cs.setLeading(20f);
		      cs.newLineAtOffset(170, 610);
		      cs.showText(user);
		      cs.newLine();
		      cs.showText(cpf);
		      cs.endText();
		      
		      cs.beginText();
		      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
		      cs.newLineAtOffset(80, 540);
		      cs.showText("Produto");
		      cs.endText();
		      
		      cs.beginText();
		      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
		      cs.newLineAtOffset(200, 540);
		      cs.showText("Valor");
		      cs.endText();
		      
		      cs.beginText();
		      cs.setFont(PDType1Font.TIMES_ROMAN, 12);
		      cs.setLeading(20f);
		      cs.newLineAtOffset(80, 520);
		      cs.showText("Compra de crédito");
		      cs.endText();
		      
		      cs.beginText();
		      cs.setFont(PDType1Font.TIMES_ROMAN, 12);
		      cs.setLeading(20f);
		      cs.newLineAtOffset(200, 520);
		      cs.showText("R$ " + value);
		      cs.endText();
		      
		      
		      cs.close();
		      invc.save("C:\\Users\\User\\Documents\\ViacaoPaulista\\ViacaoPaulista\\src\\anexos\\Boleto.pdf");
		      
		      
		    
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

package com.hmkcode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class App 
{
    public static void main( String[] args ) throws DocumentException, IOException
    {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            lines.add(new Line("Field" + i, "Value" + i));
        }

         /*  first, get and initialize an engine  */
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        /*  next, get the Template  */
        Template t = ve.getTemplate("index.vm");
        /*  create a context and add data */
        VelocityContext context = new VelocityContext();
        context.put("lines", lines);
        /* now render the template into a StringWriter */
        StringWriter stringWriter = new StringWriter();
        t.merge( context, stringWriter );
        /* show the World */
        String html = stringWriter.toString();

        System.out.println(html);

      // step 1
    	Document document = new Document();
        document.setPageSize(PageSize.A4.rotate());
        // step 2
    	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdf.pdf"));

        // step 3
        document.open();
        // step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new StringReader(html));
//                new FileInputStream("index.html"));

                //step 5
                document.close();

        System.out.println( "PDF Created!" );
    }
}

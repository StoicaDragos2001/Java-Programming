package commands;

import catalog.Catalog;
import exception.CustomException;

import java.awt.*;
import java.io.*;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ReportCommand extends GenericCommand{
    public ReportCommand(Catalog catalog) {
        super(catalog);
        callMethod = "report method";
    }

    @Override
    public void execute(String stringGiven) throws CustomException, IOException, ClassNotFoundException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File(stringGiven));
        Template temp = cfg.getTemplate("templateFile.ftlh");
        Writer out = new OutputStreamWriter(new FileOutputStream("templateFile.html"));
        try {
            temp.process(catalog, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        File u = new File(stringGiven+"templateFile.html");
        Desktop d = Desktop.getDesktop();
        d.open(u);
    }

}

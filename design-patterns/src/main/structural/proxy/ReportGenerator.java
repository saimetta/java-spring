package main.structural.proxy;

public interface ReportGenerator {
	
    String displayReportTemplate(String reportFormat,int reportEntries);
    String generateComplexReport(String reportFormat,int reportEntries);
    String generateSensitiveReport();
}

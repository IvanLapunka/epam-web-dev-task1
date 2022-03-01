package by.training.task1.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class GemErrorHandler implements ErrorHandler {
    private static Logger log = LogManager.getLogger();
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        log.warn(getErrorLine(exception) + " " + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        log.error(getErrorLine(exception) + " " + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        log.fatal(getErrorLine(exception) + " " + exception.getMessage());
    }

    private String getErrorLine(SAXParseException exception) {
        return exception.getLineNumber() + ":" + exception.getColumnNumber();
    }
}

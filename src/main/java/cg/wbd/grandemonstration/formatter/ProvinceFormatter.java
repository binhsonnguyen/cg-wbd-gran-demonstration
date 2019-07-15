package cg.wbd.grandemonstration.formatter;

import cg.wbd.grandemonstration.model.Province;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ProvinceFormatter implements Formatter<Province> {
    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(Province object, Locale locale) {
        return null;
    }
}

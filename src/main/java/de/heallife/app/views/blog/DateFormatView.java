package de.heallife.app.views.blog;

import com.vaadin.flow.component.html.Paragraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public interface DateFormatView {

    default String formatDate(Instant instant) throws ParseException {

        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.GERMAN);

        return ldt.format(format);
    }



}

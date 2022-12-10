package de.wpwa.app.views.blog;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public interface DateFormatView {

  default String formatDate(Instant instant) throws ParseException {

    LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.GERMAN);

    return ldt.format(format);
  }
}

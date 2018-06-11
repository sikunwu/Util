package com.chinadci.backendservice.common.dateEditor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date>
{
  private String pattern;


  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }


  @Override
  public Date convert(String strDate) {

    SimpleDateFormat df=new SimpleDateFormat(pattern);

    try {
      return df.parse(strDate);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      System.out.println("日期转换异常");
      return null;
    }
  }


}

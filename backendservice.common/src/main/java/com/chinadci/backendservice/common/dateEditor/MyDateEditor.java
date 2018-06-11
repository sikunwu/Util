package com.chinadci.backendservice.common.dateEditor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class MyDateEditor extends PropertiesEditor
{
  protected Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void setAsText(String souece) throws IllegalArgumentException
  {
    SimpleDateFormat sdf=getDate(souece);
    try {
        setValue(sdf.parse(souece));
    }catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

  private SimpleDateFormat getDate(String source)
  {
    SimpleDateFormat simpleDateFormat=null;
    if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$",source))
    {
      simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    }else if (Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$",source))
    {
      simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
    }else if (Pattern.matches("^\\d{4}\\d{2}\\d{2}$",source))
    {
      simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
    }else
    {
      throw new TypeMismatchException("", Date.class);
    }
    return simpleDateFormat;
  }
}

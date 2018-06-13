package com.chinadci.basebackendservice.common.dataTypeAdaptor;

import com.chinadci.basebackendservice.model.ServiceListResult;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTypeAdaptor extends TypeAdapter<ServiceListResult> {
  public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
      if (type.getRawType() == ServiceListResult.class) {
        return (TypeAdapter<T>) new DataTypeAdaptor(gson);
      }
      return null;
    }
  };

  private final Gson gson;

  DataTypeAdaptor(Gson gson) {
    this.gson = gson;
  }

  @Override
  public void write(JsonWriter out, ServiceListResult value) throws IOException {
    if (value == null) {
      out.nullValue();
      return;
    }

    out.beginObject();
    out.name("ReturnCode");
    gson.getAdapter(Integer.class).write(out, value.ReturnCode);
    out.name("Message");
    gson.getAdapter(String.class).write(out, value.Message);
    out.name("Data");
    gson.getAdapter(Object.class).write(out,value.Data);
    out.endObject();
  }

  @Override
  public ServiceListResult read(JsonReader in) throws IOException {
    ServiceListResult data = new ServiceListResult();
    Map<String, Object> dataMap = (Map<String, Object>) readInternal(in);
    data.ReturnCode=((Integer)dataMap.get("ReturnCode"));
    data.Message= (String) dataMap.get("Message");
    data.Data=dataMap.get("Data");
    return data;
  }


  private Object readInternal(JsonReader in) throws IOException {
    JsonToken token = in.peek();
    switch (token) {
      case BEGIN_ARRAY:
        List<Object> list = new ArrayList<Object>();
        in.beginArray();
        while (in.hasNext()) {
          list.add(readInternal(in));
        }
        in.endArray();
        return list;

      case BEGIN_OBJECT:
        Map<String, Object> map = new LinkedTreeMap<String, Object>();
        in.beginObject();
        while (in.hasNext()) {
          map.put(in.nextName(), readInternal(in));
        }
        in.endObject();
        return map;

      case STRING:
        return in.nextString();

      case NUMBER:
        //将其作为一个字符串读取出来
        String numberStr = in.nextString();
        //返回的numberStr不会为null
        if (numberStr.contains(".") || numberStr.contains("e")
          || numberStr.contains("E")) {
          return Double.parseDouble(numberStr);
        }
        //return Long.parseLong(numberStr);
        return Integer.parseInt(numberStr);

      case BOOLEAN:
        return in.nextBoolean();

      case NULL:
        in.nextNull();
        return null;

      default:
        throw new IllegalStateException();
    }
  }

}

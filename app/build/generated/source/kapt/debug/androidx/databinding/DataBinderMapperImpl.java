package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.karan.kisan_network.DataBinderMapperImpl());
  }
}

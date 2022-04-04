package com.example.cleanarchitecturestudy;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.cleanarchitecturestudy.databinding.ActivityMovieSearchBindingImpl;
import com.example.cleanarchitecturestudy.databinding.ActivityQrBindingImpl;
import com.example.cleanarchitecturestudy.databinding.ActivityWebBindingImpl;
import com.example.cleanarchitecturestudy.databinding.ItemMovieBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMOVIESEARCH = 1;

  private static final int LAYOUT_ACTIVITYQR = 2;

  private static final int LAYOUT_ACTIVITYWEB = 3;

  private static final int LAYOUT_ITEMMOVIE = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.cleanarchitecturestudy.R.layout.activity_movie_search, LAYOUT_ACTIVITYMOVIESEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.cleanarchitecturestudy.R.layout.activity_qr, LAYOUT_ACTIVITYQR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.cleanarchitecturestudy.R.layout.activity_web, LAYOUT_ACTIVITYWEB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.cleanarchitecturestudy.R.layout.item_movie, LAYOUT_ITEMMOVIE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMOVIESEARCH: {
          if ("layout/activity_movie_search_0".equals(tag)) {
            return new ActivityMovieSearchBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_movie_search is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYQR: {
          if ("layout/activity_qr_0".equals(tag)) {
            return new ActivityQrBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_qr is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWEB: {
          if ("layout/activity_web_0".equals(tag)) {
            return new ActivityWebBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_web is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMMOVIE: {
          if ("layout/item_movie_0".equals(tag)) {
            return new ItemMovieBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_movie is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "movie");
      sKeys.put(2, "vm");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_movie_search_0", com.example.cleanarchitecturestudy.R.layout.activity_movie_search);
      sKeys.put("layout/activity_qr_0", com.example.cleanarchitecturestudy.R.layout.activity_qr);
      sKeys.put("layout/activity_web_0", com.example.cleanarchitecturestudy.R.layout.activity_web);
      sKeys.put("layout/item_movie_0", com.example.cleanarchitecturestudy.R.layout.item_movie);
    }
  }
}

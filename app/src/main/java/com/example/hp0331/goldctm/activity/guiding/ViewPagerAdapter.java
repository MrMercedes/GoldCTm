/**
 * 
 */
package com.example.hp0331.goldctm.activity.guiding;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * @author Administrator
 *
 */
public class ViewPagerAdapter extends PagerAdapter
{
    private List<View> views;
    private Context context;

    public ViewPagerAdapter(Context context, List<View> views)
    {
	this.context = context;
	this.views = views;
    }
    @Override
    public Object instantiateItem(View container, int position)
    {
        
	((ViewPager)container).addView(views.get(position));
        return views.get(position);
    }
    @Override
    public void destroyItem(View container, int position, Object object)
    {
        ((ViewPager)container).removeView(views.get(position));
    }
    @Override
    public int getCount()
    {
	return views.size();
    }
    @Override
    public boolean isViewFromObject(View arg0, Object arg1)
    {
	  return arg0==arg1;
    }

}

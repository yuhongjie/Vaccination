package cn.mointe.vaccination.test;

import java.io.InputStream;
import java.util.List;

import android.test.AndroidTestCase;
import android.util.Log;
import cn.mointe.vaccination.domain.City;
import cn.mointe.vaccination.domain.Province;
import cn.mointe.vaccination.other.CityPullParseXml;

public class ProvinceTest extends AndroidTestCase {

	public void testGetProvinces() throws Exception {
		InputStream xml = this.getContext().getResources().getAssets()
				.open("province.xml");
		List<Province> provinces = CityPullParseXml.getProvinces(xml);
		for (Province province : provinces) {
			Log.i("MainActivity", "provinceName=" + province.getProviceName());
		}
	}

	public void testGetCitys() throws Exception {
		InputStream xml = this.getContext().getResources().getAssets()
				.open("city_jilin.xml");
		List<City> citys = CityPullParseXml.getCitys(xml);
		for (City city : citys) {
			Log.i("MainActivity", "provinceName=" + city.getCityName());
			List<String> countys = city.getCountys();
			for (String county : countys) {
				Log.e("MainActivity", county);
			}
		}
	}
}
package cn.mointe.vaccination.test;

import java.util.Date;

import cn.mointe.vaccination.dao.BabyDao;
import cn.mointe.vaccination.db.DBHelper;
import cn.mointe.vaccination.domain.Baby;
import cn.mointe.vaccination.provider.BabyProvider;
import cn.mointe.vaccination.tools.DateUtils;
import android.content.ContentResolver;
import android.database.Cursor;
import android.test.AndroidTestCase;
import android.util.Log;

public class BabyProviderTest extends AndroidTestCase {

	public void testQuery() {
		ContentResolver resolver = getContext().getContentResolver();
		Cursor cursor = resolver.query(BabyProvider.CONTENT_URI, null, null,
				null, null);
		while (cursor.moveToNext()) {
			String name = cursor.getString(cursor
					.getColumnIndex(DBHelper.BABY_COLUMN_NAME));
			String isdefault = cursor.getString(cursor
					.getColumnIndex(DBHelper.BABY_COLUMN_IS_DEFAULT));
			Log.i("MainActivity", name + "--" + isdefault);
		}
	}

	public void testQueryDefaultBaby() {
		BabyDao dao = new BabyDao(getContext());
		Baby baby = dao.getDefaultBaby();
		Log.i("MainActivity", baby.getName() + "-" + baby.getIs_default());
	}

	public void testDate() {
		Log.i("MainActivity", "" + DateUtils.getMonth("2014-03-11", new Date()));
	}
}
package ca.ualberta.cs.lonelytwitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

public class TweetsFileManager {

	public static final String FILE_SAV = "file.sav";
	public static final String LONELY_TWITTER = "LonelyTwitter";
	public static final String ERROR_CASTING = "Error casting";
	private Context ctx;

	public TweetsFileManager(Context ctx) {
		this.ctx = ctx;
	}

	@SuppressWarnings("unchecked")
	public List<NormalTweet> loadTweets() {
		List<NormalTweet> tweets = new ArrayList<NormalTweet>();

		try {
			FileInputStream fis = ctx.openFileInput("file.sav");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Object o = ois.readObject();

			if (o instanceof ArrayList) {
				tweets = (ArrayList<NormalTweet>) o;
			} else {
				Log.i(LONELY_TWITTER, ERROR_CASTING);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return tweets;
	}

	public void saveTweets(List<NormalTweet> tweets) {
		try {
			FileOutputStream fos = ctx.openFileOutput(FILE_SAV, 0);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(tweets);

			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
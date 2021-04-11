package com.riseinsteps.retrofitwithroom;

import android.app.Application;
import android.os.AsyncTask;

public class Repository {
    private ModelDatabase modelDatabase;
    private RoomDao roomDao;
    private Model model;

    public Repository(Application application) {
        modelDatabase = ModelDatabase.getInstance(application.getApplicationContext());
        roomDao = modelDatabase.roomDao();
        model = roomDao.getModel();
    }

    public void insert(Model model) {
        new InsertAsyncTask(roomDao).execute(model);
    }

    public Model model() {
        return model;
    }

    private class InsertAsyncTask extends AsyncTask<Model, Void, Void> {
        private RoomDao roomDao;

        public InsertAsyncTask(RoomDao roomDao) {
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(Model... models) {
            roomDao.insert(models[0]);
            return null;
        }
    }
}

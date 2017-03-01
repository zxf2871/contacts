/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cpic.contacts.login.source;

import android.support.annotation.NonNull;

import com.cpic.contacts.login.User;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Concrete implementation to load tasks from the data sources into a cache.
 * <p>
 * For simplicity, this implements a dumb synchronisation between locally persisted data and data
 * obtained from the server, by using the remote data source only if the local database doesn't
 * exist or is empty.
 */
public class UserRepository implements UserDataSource {

    private static UserRepository INSTANCE = null;

    private final UserDataSource mUsersRemoteDataSource;

    /**
     * This variable has package local visibility so it can be accessed from tests.
     */
    User mCachedUser;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    boolean mCacheIsDirty = false;

    // Prevent direct instantiation.
    private UserRepository(@NonNull UserDataSource tasksRemoteDataSource) {
        mUsersRemoteDataSource = checkNotNull(tasksRemoteDataSource);
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param tasksRemoteDataSource the backend data source
     * @return the {@link UserRepository} instance
     */
    public static UserRepository getInstance(UserDataSource tasksRemoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository(tasksRemoteDataSource);
        }
        return INSTANCE;
    }

    /**
     * Used to force {@link #getInstance(UserDataSource)} to create a new instance
     * next time it's called.
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }


    @Override
    public void saveUser(@NonNull User task) {
        checkNotNull(task);
        mUsersRemoteDataSource.saveUser(task);
    }


    /**
     * Gets tasks from local data source (sqlite) unless the table is new or empty. In that case it
     * uses the network data source. This is done to simplify the sample.
     * <p>
     * Note: {@link GetUserCallback#onDataNotAvailable()} is fired if both data sources fail to
     * get the data.
     */
    @Override
    public void getUser(@NonNull final String taskId, @NonNull final GetUserCallback callback) {
        checkNotNull(taskId);
        checkNotNull(callback);

        User cachedUser = mCachedUser;

        // Respond immediately with cache if available
        if (cachedUser != null) {
            callback.onUserLoaded(cachedUser);
            return;
        }
    }
}

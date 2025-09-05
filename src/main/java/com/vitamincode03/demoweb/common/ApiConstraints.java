package com.vitamincode03.demoweb.common;

public class ApiConstraints {

    private ApiConstraints(){

    }

    public static final String BASE_API = "/api";
    public static final String VERSION_V1 = BASE_API + "/v1";

    public static final class ApiUser {
        public static final String BASE = VERSION_V1 + "/users";

        public static final String GET_ALL_USER = "/get-all-user";
        public static final String GET_BY_USERNAME = "/get-by-username";
        public static final String GET_BY_LIST_USERNAME = "/get-by-list-username";

        public static final String CREATE = "/create";
        public static final String UPDATE = "/update";
        public static final String SAVE = "/save";
        public static final String DELETE = "/delete";


        private ApiUser() {}
    }

}

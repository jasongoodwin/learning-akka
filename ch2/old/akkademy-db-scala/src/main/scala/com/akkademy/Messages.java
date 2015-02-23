package com.akkademy;

public interface Messages {
    public static interface Request {}
    public static class Get implements Request {
        public final String key;

        public Get(String key) {
            this.key = key;
        }
    }

    public static class Set implements Request {
        public final String key;
        public final Object value;

        public Set(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class SetIfNotExists implements Request {
        public final String key;
        public final Object value;

        public SetIfNotExists(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class Delete implements Request {
        public final String key;

        public Delete(String key) {
            this.key = key;
        }
    }

    public static interface Response {}
    public static class Ok implements Response {}
    public static class Faiure implements Response {}
}

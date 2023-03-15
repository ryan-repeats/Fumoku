package live.ryyvv.fumoku.utils

val Any.TAG: String
    get() {
        return if (javaClass.isAnonymousClass) javaClass.name else javaClass.simpleName
    }

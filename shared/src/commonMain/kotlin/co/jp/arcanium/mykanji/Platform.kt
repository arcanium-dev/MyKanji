package co.jp.arcanium.mykanji

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
package com.seonjk.smartdeliveryclone.data.entity

import com.google.gson.annotations.SerializedName

/**
 * 진행 단계
 * [level 1: 배송준비중, 2: 집화완료, 3: 배송중, 4: 지점 도착, 5: 배송출발, 6:배송 완료]
 * */
enum class Level(val label: String) {
    @SerializedName("1")
    PREPARE("배송 준비중"),

    @SerializedName("2")
    READY_FOR_SHIPPING("집화 완료"),

    @SerializedName("3")
    ON_TRANSIT("배송 중"),

    @SerializedName("4")
    ON_ARRIVE_ROUTER("지점 도착"),

    @SerializedName("5")
    START("배송 출발"),

    @SerializedName("6")
    COMPLETE("배송 완료")
}
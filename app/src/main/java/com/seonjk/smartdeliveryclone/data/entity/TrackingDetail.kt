package com.seonjk.smartdeliveryclone.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrackingDetail(
    /** 배송 상태 코드 */
    @SerializedName("code")
    val code: String? = null,
    /** 진행 상태 */
    @SerializedName("kind")
    val kind: String? = null,
    /** 진행 단계 */
    @SerializedName("level")
    val level: Int? = null,
    /** 배송기사 이름 */
    @SerializedName("manName")
    val manName: String? = null,
    /** 배송기사 전화번호 */
    @SerializedName("manPic")
    val manPic: String? = null,
    /** 비고 */
    @SerializedName("remark")
    val remark: String? = null,
    /** 진행 위치(지점) 전화번호 */
    @SerializedName("telNo")
    val telNo: String? = null,
    /** 배송기사 전화번호 */
    @SerializedName("telNo2")
    val telNo2: String? = null,
    /** 진행 시간 */
    @SerializedName("time")
    val time: Long? = null,
    /** 진행 시간 */
    @SerializedName("timeString")
    val timeString: String? = null,
    /** 진행 위치 지점 */
    @SerializedName("where")
    val `where`: String? = null
) : Parcelable

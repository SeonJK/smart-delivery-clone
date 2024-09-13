package com.seonjk.smartdeliveryclone.data.repository

import com.seonjk.smartdeliveryclone.data.api.Companies
import com.seonjk.smartdeliveryclone.data.api.SDStatus
import com.seonjk.smartdeliveryclone.data.entity.ShippingCompany

interface ShippingCompanyRepository {
    /**
     * 택배사 조회
     * */
    suspend fun getShippingCompanies(): List<ShippingCompany>

    /**
     * 추천 택배사 목록 가져오기
     * @param apiKey 스마트 택배 API_KEY
     * @param invoice 운송장 번호
     * */
    suspend fun getRecommendShippingCompanies(
        invoice: String
    ): ShippingCompany?
}
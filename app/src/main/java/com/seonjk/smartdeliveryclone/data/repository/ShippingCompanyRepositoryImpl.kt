package com.seonjk.smartdeliveryclone.data.repository

import com.seonjk.smartdeliveryclone.data.api.Companies
import com.seonjk.smartdeliveryclone.data.api.SDStatus
import com.seonjk.smartdeliveryclone.data.entity.ShippingCompany
import com.seonjk.smartdeliveryclone.network.ApiService

class ShippingCompanyRepositoryImpl(
    private val apiService: ApiService
) : ShippingCompanyRepository {
    override suspend fun getShippingCompanies(): List<ShippingCompany> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecommendShippingCompanies(invoice: String): ShippingCompany? {
        TODO("Not yet implemented")
    }

}
package com.zhigaras.reddit.data.remote.response.more

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.zhigaras.reddit.data.remote.response.MapData
import com.zhigaras.reddit.domain.model.AbstractRedditEntity
import com.zhigaras.reddit.domain.model.MoreEntity

@JsonClass(generateAdapter = true)
data class MoreDto(
    @Json(name = "count")
    val count: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "parent_id")
    val parentId: String,
    @Json(name = "children")
    val children: List<String>
) : MapData {
    override fun map(): AbstractRedditEntity {
        return MoreEntity(
            id = id,
            name = name,
            children = children
        )
    }
}
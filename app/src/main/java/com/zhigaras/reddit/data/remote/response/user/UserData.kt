package com.zhigaras.reddit.data.remote.response.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.zhigaras.reddit.data.remote.response.Thing

@JsonClass(generateAdapter = true)
data class UserData(
    @Json(name = "kind")
    override val kind: String,
    @Json(name = "data")
    override val data: UserDto
): Thing

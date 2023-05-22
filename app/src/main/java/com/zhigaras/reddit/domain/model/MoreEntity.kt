package com.zhigaras.reddit.domain.model

class MoreEntity(
    override val id: String,
    val name: String,
    val children: List<String>
) : AbstractRedditEntity()
package com.bimabagaskhoro.mysalesapp.utils

import com.bimabagaskhoro.mysalesapp.data.source.remote.response.onTask.DataItemOnTask
import com.bimabagaskhoro.mysalesapp.data.source.remote.response.task.DataItem
import com.bimabagaskhoro.mysalesapp.data.source.remote.response.users.Data
import com.bimabagaskhoro.mysalesapp.data.source.remote.response.users.DataItemUsers
import com.bimabagaskhoro.mysalesapp.data.source.remote.response.users.ResponseLogin
import com.bimabagaskhoro.mysalesapp.domain.model.ontask.ItemOntask
import com.bimabagaskhoro.mysalesapp.domain.model.task.ItemTask
import com.bimabagaskhoro.mysalesapp.domain.model.users.ItemUsers
import com.bimabagaskhoro.mysalesapp.domain.model.users.ItemUsersLogin

object DataMapper {
    fun entitiesToDomain(data: List<DataItem>): List<ItemTask> =
        data.map {
            ItemTask(
                level = it.level,
                name = it.name,
                id = it.id,
                location = it.location,
                status = it.status
            )
        }

    fun domainToEntity(data: ItemOntask): DataItemOnTask =
        DataItemOnTask(
            name = data.name,
            capture = data.capture,
            location = data.location,
            id = data.id,
            status = data.status
        )

    fun entitiesToDomainOnTask(data: List<DataItemOnTask>): List<ItemOntask> =
        data.map {
            ItemOntask(
                name = it.name,
                capture = it.capture,
                location = it.location,
                id = it.id,
                status = it.status
            )
        }

    fun domainToEntityRegister(data: ItemUsers): DataItemUsers =
        DataItemUsers(
            name = data.name,
            email = data.email,
            password = data.password
        )

    fun entityToDomainLogin(data: Data): ItemUsersLogin =
        ItemUsersLogin(
            token = data.token
        )

}
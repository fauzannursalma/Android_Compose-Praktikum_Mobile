package com.unpas.tif.prakmobile.fauzann.setoransampah.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawerContent(onClick: (String) -> Unit)
{
    val menus = listOf(
        Menu.HOME,
        Menu.PENGELOLAAN_SAMPAH,
        Menu.SETTING)
    val listState = rememberLazyListState()
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
    ) {
        Row (modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.Center) {
            Text("Selamat Datang", modifier =
            Modifier.height(32.dp).padding(2.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold)
        }
        Divider(startIndent = 8.dp, thickness = 1.dp, color =
        Color.Black)
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(0.dp)
        ) {
            items(menus) { menu ->
                Card(
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    contentColor = Color.Black
                ) {
                    Row (modifier =
                    Modifier.padding(5.dp).clickable {
                        onClick(menu.route)
                    }) {
                        Icon(
                            menu.icon,
                            modifier =
                            Modifier.height(32.dp).width(32.dp),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                        Text(
                            stringResource(id = menu.title),
                            modifier =
                            Modifier.height(32.dp).padding(2.dp),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold)
                    }
                }

            }
        }
    }
}
/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import com.bumptech.glide.request.RequestOptions
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.BirdRepository
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun ItemBird(
    birdIndex: Int,
    preferredImageSize: Dp = 120.dp,
    onBirdClicked: (index: Int) -> Unit
) {
    val bird = BirdRepository.birds[birdIndex]
    val bitmap = BitmapFactory.decodeResource(
        LocalContext.current.resources, bird.pictureResId
    )
    val palette = Palette.from(bitmap).generate()
    val defaultColor = ContextCompat.getColor(LocalContext.current, R.color.teal_700)
    val color = palette.getVibrantColor(defaultColor)
    Card(
        backgroundColor = Color(color),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(PaddingValues(horizontal = 2.dp, vertical = 2.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable(onClick = { onBirdClicked(birdIndex) })
                .padding(PaddingValues(all = 16.dp))
        ) {
            GlideImage(
                data = bird.pictureResId,
                contentDescription = "Bird Image",
                modifier = Modifier.size(preferredImageSize),
                requestBuilder = {
                    val options = RequestOptions()
                    options.circleCrop()
                    apply(options)
                }
            )
            Text(
                text = bird.name,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(top = 8.dp),
                color = Color.White
            )
            Text(
                text = bird.species,
                style = MaterialTheme.typography.subtitle2,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun ItemBirdPreview() {
    MyTheme(darkTheme = true) {
        ItemBird(2) { }
    }
}

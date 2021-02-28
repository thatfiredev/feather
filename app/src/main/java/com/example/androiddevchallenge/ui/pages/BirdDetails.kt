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
package com.example.androiddevchallenge.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.request.RequestOptions
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.BirdRepository
import com.example.androiddevchallenge.model.Bird
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun BirdDetails(birdIndex: Int) {
    val bird = BirdRepository.birds[birdIndex]
    Scaffold(
        content = {
            Column {
                Header(bird.pictureResId, bird.name)
                Details(bird)
            }
        }
    )
}

@Composable
fun Header(birdPicResId: Int, birdName: String) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            GlideImage(
                data = birdPicResId,
                contentDescription = "$birdName's image",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                requestBuilder = {
                    val options = RequestOptions()
                    options.centerCrop()
                    apply(options)
                }
            )
        }
    }
}

@Composable
fun Details(bird: Bird) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
    ) {
        Text(text = bird.name, style = MaterialTheme.typography.h4)
        Text(text = bird.species, style = MaterialTheme.typography.h5)

        val description = stringResource(
            id = R.string.description_placeholder, bird.name,
            bird.gender, bird.species
        )
        Text(
            text = description, style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Justify, modifier = Modifier.padding(horizontal = 0.dp, vertical = 16.dp)
        )
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth().height(48.dp),
            shape = MaterialTheme.shapes.small
        ) {
            Text(text = stringResource(id = R.string.action_adopt), fontSize = 18.sp)
        }
    }
}

@Preview
@Composable
fun BirdDetailsPreview() {
    MyTheme {
        BirdDetails(1)
    }
}

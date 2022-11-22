package com.example.catalogocompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catalogocompose.R

@Preview(showBackground = true)
@Composable
fun PlayerMainScreen() {
    Box(modifier = Modifier
        .background(Color(0xffecefe7))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color(0xffecefe7))
        ) {
            Spacer(modifier = Modifier.size(50.dp))
            OptionsMenu()
            Spacer(modifier = Modifier.size(30.dp))
            AlbumImage()
            Spacer(modifier = Modifier.size(30.dp))
            TrackInfo()
            Spacer(modifier = Modifier.size(20.dp))
            PlayingControls()
            Spacer(modifier = Modifier.size(20.dp))
            Footer()
            Spacer(modifier = Modifier.size(50.dp))
        }
    }

}

@Composable
fun OptionsMenu() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Icon(imageVector = Icons.Outlined.ExpandMore, contentDescription = "Expand more")
        Spacer(modifier = Modifier.weight(1F))
        Icon(imageVector = Icons.Outlined.MoreVert, contentDescription = "More options")
    }
}

@Composable
fun AlbumImage() {
    Image(
        painter = painterResource(id = R.drawable.album_image),
        contentDescription = "Album image",
        modifier = Modifier.clip(RoundedCornerShape(20.dp))
    )
}

@Composable
fun TrackInfo() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.TopStart),
            text = "The adults are talking",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xff3b4833)
        )
        Text(modifier = Modifier.align(Alignment.BottomStart), text = "The Strokes", color = Color(0xff3b4833))
        Icon(
            modifier = Modifier.align(Alignment.CenterEnd),
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Like Track"
        )
    }
}

@Composable
fun PlayingControls() {
    Column(modifier = Modifier.fillMaxWidth()) {
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth(), progress = 0.6F, color = Color(0xff3b4833))
        Spacer(modifier = Modifier.size(2.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1F))
            Text(modifier = Modifier,text = "2:09 / 3:59")
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {

            Button(modifier = Modifier.size(50.dp),shape = CircleShape, contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xffc7d3bb)
                ),
                onClick = { /*TODO*/ }) {
                Icon(modifier = Modifier.size(35.dp), imageVector = Icons.Rounded.SkipPrevious, contentDescription = "Previous track")
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(modifier = Modifier
                .clip(RoundedCornerShape(40))
                .height(60.dp)
                .width(80.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xffbdeb9e)
                ),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.Pause, contentDescription = "Pause track")
            }
            Spacer(modifier = Modifier.size(16.dp))
            // #c7d3bb
            Button(modifier = Modifier.size(50.dp),shape = CircleShape, contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xffc7d3bb)
                )
                ,onClick = { /*TODO*/ }) {
                Icon(modifier = Modifier.size(35.dp), imageVector = Icons.Rounded.SkipNext, contentDescription = "Previous track")
            }

        }

    }
}

@Composable
fun Footer() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        IconButton(modifier = Modifier
            .clip(CircleShape)
            .background(color = Color(0xffbdeb9e))
            .size(30.dp), onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Rounded.VolumeUp, contentDescription = "Footer")
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "EDIFIER R1280DB")
        Spacer(modifier = Modifier.weight(1F))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Rounded.PlaylistPlay, contentDescription = "PlayList")
        }
    }
}
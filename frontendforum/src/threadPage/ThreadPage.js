import './ThreadPage.css';
import axios from 'axios';
import React, { useState, useEffect } from "react";
import {Paper, IconButton} from '@mui/material/';
import { List } from '@mui/icons-material';

import {
    BrowserRouter as Router,
    Routes,
    Route,
    Link,
    Navigate,
  } from "react-router-dom";

function ThreadPage() {


    const [threadLists, setThreadLists] = useState([]);

    useEffect(() => {
        // Simple GET request using axios
        axios.get("http://localhost:8080/thread/api/all")
        .then(response=>{
          console.log(response)
          setThreadLists(response.data);
        })
      },[]);

    const threadList = [
        {
            id: "0",
            threadName: "Cooking thread"
        },
        {
            id: "1",
            threadName: "Martial arts thread"
        },
        {
            id: "2",
            threadName: "Videogames arts thread"
        }
    ]

    const handleClick = (threadId) => {
        console.log(threadId);
    }

    return (
        <div className='threadView'>
           
            {threadLists.map((threadItem) => (
               <Link to={"/thread/" + threadItem.id} style={{ textDecoration: 'none' }}>
                    <Paper className='threadItemList' elevation={4} align='center' onClick={() => handleClick(threadItem.id)}>
                        <p>{threadItem.name}</p>
                    </Paper>
                </Link>
            ))} 
            
        </div>
    );
}


export default ThreadPage;
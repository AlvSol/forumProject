import "./PostsPage.css"

import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import Menu from '@mui/material/Menu';
import MenuIcon from '@mui/icons-material/Menu';
import Container from '@mui/material/Container';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import Tooltip from '@mui/material/Tooltip';
import MenuItem from '@mui/material/MenuItem';
import AdbIcon from '@mui/icons-material/Adb';
import TextField from '@mui/material/TextField';
import Switch from '@mui/material/Switch';
import PropTypes from 'prop-types';
import { alpha } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TablePagination from '@mui/material/TablePagination';
import TableRow from '@mui/material/TableRow';
import TableSortLabel from '@mui/material/TableSortLabel';
import Paper from '@mui/material/Paper';
import Checkbox from '@mui/material/Checkbox';
import FormControlLabel from '@mui/material/FormControlLabel';
import DeleteIcon from '@mui/icons-material/Delete';
import FilterListIcon from '@mui/icons-material/FilterList';
import { visuallyHidden } from '@mui/utils';
import InputLabel from '@mui/material/InputLabel';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Alert from '@mui/material/Alert';
import Stack from '@mui/material/Stack';
import Collapse from '@mui/material/Collapse';
import CloseIcon from '@mui/icons-material/Close';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';

import { styled } from '@mui/material/styles';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import FormGroup from '@mui/material/FormGroup';
import Grid from '@mui/material/Grid';
import FolderIcon from '@mui/icons-material/Folder';
import Divider from '@mui/material/Divider';

import axios from 'axios';
import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

function PostsPage(props){

    const { id } = useParams();
    const [postsList, setPostsList] = useState([]);

    useEffect(() => {
        // Simple GET request using axios
        axios.get("http://localhost:8080/thread/api/allposts/" + id)
        .then(response=>{
          console.log(response)
          setPostsList(response.data);
        })
      },[]);

    const rows = [
        {
            id:'',
            title:'TITLE',
            text:'SUBTITLE',
            threadId:'',
            type:0,
        },        
        {
            id:'',
            title:'TITLE',
            text:'SUBTITLE',
            threadId:'',
            type:0,
        },        
        {
            id:'',
            title:'TITLE',
            text:'SUBTITLE',
            threadId:'',
            type:1,
        },        
        {
            id:'',
            title:'TITLE',
            text:'SUBTITLE',
            threadId:'',
            type:2,
        },
    ];

    function GetIcon(postId){
        if      (postId == 0)   return <> <span class="material-symbols-outlined">question_mark </span> </>;
        else if (postId == 2)   return <> <span class="material-symbols-outlined">volume_mute </span> </>;
        else                    return <> <span class="material-symbols-outlined">edit </span> </>;
    }

    //new post popup
    const [postOpen, setPostOpen] = React.useState(false);
    const handleClickPostOpen = () => {
        setPostOpen(true);
    };
    const handlePostClose = () => {
        setPostOpen(false);
    };
    //new post visibility popup
    const [viewOpen, setviewOpen] = React.useState(false);
    const handleViewClickOpen = () => {
        setviewOpen(true);
    };
    const handleViewClose = () => {
        setviewOpen(false);
    };

    function CloseAllPopUps(){
        handleViewClose();
        handlePostClose();
    }
  
    return(
        <>
        <body>
            <div className="PostsContainer">
                <div className="PostsHead">
                    <h1 className="ThreadTitle">Thread Title</h1>
                    <Button onClick={handleClickPostOpen} className="addPostButton" variant="contained">Add Post </Button>
                </div>
                <TableContainer component={Paper}>
                    <Table sx={{ minWidth: 650 }} aria-label="simple table">
                        <TableBody>
                            {postsList.map((row) => (
                                <tr
                                    className="PostRow"
                                    key={row.name}
                                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}                                    
                                >
                                    <TableCell component="th" scope="row"> {
                                        GetIcon(row.type)} 
                                    </TableCell>
                                    <TableCell align="center">{row.title}</TableCell>
                                    <TableCell align="right">{row.text}</TableCell>
                                </tr>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
            </div>

            <div className="CreatePostPopUp">
                <Dialog open={postOpen} onClose={handlePostClose}>
                    <DialogTitle>Create Post</DialogTitle>
                    <DialogContent>
                    <Box
                        noValidate
                        component="form"
                        sx={{
                            display: 'flex',
                            flexDirection: 'column',
                            m: 'auto',
                            width: 'fit-content',
                        }}
                    >
                    <FormControl sx={{ mt: 2, minWidth: 120 }}>
                        <InputLabel htmlFor="max-width">Post Type</InputLabel>
                        <Select
                            autoFocus
                            // value={maxWidth}
                            // onChange={handleMaxWidthChange}
                            label="postType"
                            inputProps={{
                            name: 'Post-Type',
                            id: 'postType',
                            }}
                        >
                            <MenuItem value={0}>Doubt</MenuItem>
                            <MenuItem value={1}>Suggestion</MenuItem>
                            <MenuItem value={2}>Clarification</MenuItem>
                        </Select>
                    </FormControl>
                </Box>
                        <TextField
                            autoFocus
                            margin="dense"
                            id="name"
                            label="Post Title"
                            fullWidth
                            variant="standard"
                        />
                        <TextField
                            autoFocus
                            margin="dense"
                            id="name"
                            label="Post text"
                            fullWidth
                            variant="standard"
                        />
                    </DialogContent>
                    <DialogActions>
                        <Button onClick={handlePostClose}>Cancel</Button>
                        <Button onClick={handleViewClickOpen} variant="contained">Upload</Button>
                    </DialogActions>
                </Dialog>
            </div>
            <div className="postVisibility">
            <Dialog open={viewOpen} onClose={handleViewClose}>
                    <DialogTitle>Select Visibility</DialogTitle>
                    <DialogContent>
                    <Box
                        noValidate
                        component="form"
                        sx={{
                            display: 'flex',
                            flexDirection: 'column',
                            m: 'auto',
                            width: 'fit-content',
                        }}
                    >
                    <FormControl sx={{ mt: 2, minWidth: 120 }}>
                        <InputLabel htmlFor="max-width">Visibility Type</InputLabel>
                        <Select
                            autoFocus
                            // value={maxWidth}
                            // onChange={handleMaxWidthChange}
                            label="postType"
                            inputProps={{
                            name: 'Post-Type',
                            id: 'postType',
                            }}
                        >
                            <MenuItem value={0}>Private</MenuItem>
                            <MenuItem value={1}>Public</MenuItem>
                        </Select>
                    </FormControl>
                    </Box>
                    </DialogContent>
                    <DialogActions>
                        <Button onClick={CloseAllPopUps}>Cancel</Button>
                        <Button onClick={CloseAllPopUps} variant="contained">Upload</Button>
                    </DialogActions>
                </Dialog>
            </div>
        </body>
        </>
    )
    
}

export default PostsPage;

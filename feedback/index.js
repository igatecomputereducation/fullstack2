const express=require("express");
const usersdao = require("./service/usersdao.js");
const enqdao=require("./service/enqdao.js");
const cors=require("cors");
const app=express();

app.use(express.urlencoded({extended:true}));
app.use(express.json());
app.use(cors());

/**************User module*********************/

app.get("/allusers",function(req,res){
    usersdao.allUsers()
    .then(function(data){
        res.send(data);
    })
    .catch(function(err){
        res.send(err);
    })
})


app.post("/cruser",function(req,res){
    usersdao.addUser(req.body)
    .then(function(msg){
        res.send(msg);
    })
    .catch(function(err){
        res.send(err);
    })
})

app.delete("/dluser/:username",function(req,res){
    usersdao.removeUser(req.params.username)
    .then(function(msg){
        res.send(msg);
    })
    .catch(function(err){
        res.send(err);
    })
})

/********************Enquiry modulwe****************/


app.get("/allenq",function(req,res){
    enqdao.allEnq()
    .then(function(data){
        res.send(data);
    })
    .catch(function(err){
        res.send(err);
    })
})

app.post("/crenq",function(req,res){
    var obj=req.body;
    obj.dnt=new Date().toLocaleString();
    enqdao.addEnq(obj)
    .then(function(msg){
        res.send(msg);
    })
    .catch(function(err){
        res.send(err);
    })
})

app.delete("/dlenq/:enqid",function(req,res){

        enqdao.delEnq(req.params.enqid)
        .then(function(msg){
            res.send(msg);
        })
        .catch(function(err){
            res.send(err);
        })

})


app.get("/maxenqid",function(req,res){
    enqdao.getMaxEnqId()
    .then(function(maxenqid){
        res.send(maxenqid+"");
    })
    .catch(function(err){
        res.send(err);
    })
})

app.get("/readenq/:enqid",function(req,res){
    var enqid=req.params.enqid;
    enqdao.readEnq(enqid)
    .then(function(data){
        res.send(data);
    })
    .catch(function(err){
        res.send(err);
    })
})



app.listen(3000,function(){
    console.log("Server is waiting on port 3000");
})
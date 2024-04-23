const MongoClient=require("mongodb").MongoClient;
const client=new MongoClient("mongodb://localhost:27017");

/*=================Inserting a record=========*/

async function insertRecord(x){
    await client.connect();
    var dbo=await client.db("opencart");
    var pro=await dbo.collection("products");
    await pro.insertOne(x);
    await client.close();
    return "Record inserted";
}

/*
insertRecord({pcode:1003,pname:"Dove",price:70.50,qty:60})
.then(function(msg){
    console.log(msg);
})
.catch(function(err){
    console.log(err);
})
*/

/*================Deleting a record=============*/

async function deleteRecord(x){
    await client.connect();
    var dbo=await client.db("opencart");
    var pro=await dbo.collection("products");
    await pro.deleteOne({pcode:x});
    await client.close();
    return "Record deleted";
}

/*
deleteRecord(1000)
.then(function(msg){
    console.log(msg);
})
.catch(function(err){
    console.log(err);
})
*/

/*===============Fetching one record==============*/

async function getOneRecord(x){
    await client.connect();
    var dbo=await client.db("opencart");
    var pro=await dbo.collection("products");
    var rec=await pro.findOne({pcode:x});
    await client.close();
    if (rec==null)
        throw "No such record existed";
    return rec;
}

/*
getOneRecord(1010)
.then(function(r){
    var {id,pcode,pname,price,qty}=r;
    console.log("pcode:"+pcode);
    console.log("pname:"+pname);
    console.log("Price:"+price);
    console.log("Quantity:"+qty);
    
})
.catch(function(err){
    console.log(err);
})
*/

/*============Fetching all the records==============*/

async function getAllRecords(){
    await client.connect();
    var dbo=await client.db("opencart");
    var pro=await dbo.collection("products");
    var recs=await pro.find().toArray();
    await client.close();
    if (recs.length==0)
        throw "Table is empty";
    return recs;
}

/*
getAllRecords()
.then(function(r){
    for(let rec of r){
        var {id,pcode,pname,price,qty}=rec;
        console.log("pcode:"+pcode);
        console.log("pname:"+pname);
        console.log("Price:"+price);
        console.log("Quantity:"+qty);
        console.log("===================");
    }  
})
.catch(function(err){
    console.log(err);
})
*/

/*=============Update one record=============*/

async function updateRecord(x,rec){
    await client.connect();
    var dbo=await client.db("opencart");
    var pro=await dbo.collection("products");
    await pro.updateOne({pcode:x},rec);
    await client.close();
    return;
}


updateRecord(1000,{$set:{price:50.00}})
.then(function(r){
    console.log("Record modified");
})
.catch(function(err){
    console.log(err);
})



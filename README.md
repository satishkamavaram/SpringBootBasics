# SpringBootBasics
1 - Created Simple Rest WebService with Spring Boot.  
2 - Created a Junit Test Class with Spring + Mockito + PowerMockito  
3 - Junit test class has stubbing of instance and static method behavior.  

#Spring Boot MongoDB
1- Implemented MongoDB CRUD REST API's using HTTP VERBS 
	Creating new Chat Transaction : POST http://localhost:8080/chat/new
	Updating Chat Messages : POST http://localhost:8080/chat/message/{id}
	Ending Chat : GET http://localhost:8080/chat/end/{id}
	Getting all Chat Transactions : GET http://localhost:8080/chat/all
	Getting individual Chat Transaction : GET http://localhost:8080/chat/{id}
	Delete individual Chat Transactions : DEL http://localhost:8080/chat/{id}
2- Used Spring data Boot which provides default CRUD operations 
3- For Custom Repository methods , implemented Custom Repository class (ChatMessagesRepositoryImpl.java).

Create New Chat - POST http://localhost:8080/chat/new
{
   "id" :5,
   "messages" : [ {
                 "from" : "satish",
                 "to" : "namratha",
                 "message" : "hi"
                 }]
}

Update Chat Message - POST http://localhost:8080/chat/message/{id}
{
                 "from" : "namratha",
                 "to" : "satish",
                 "message" : "hi"
}

#Spring Boot Actuator Endpoints
 http://localhost:8080/metrics :
 
 {
  "mem": 295534,
  "mem.free": 205996,
  "processors": 2,
  "instance.uptime": 442282,
  "uptime": 451041,
  "systemload.average": 1.72998046875,
  "heap.committed": 243712,
  "heap.init": 65536,
  "heap.used": 37715,
  "heap": 932352,
  "nonheap.committed": 52840,
  "nonheap.init": 2496,
  "nonheap.used": 51824,
  "nonheap": 0,
  "threads.peak": 17,
  "threads.daemon": 15,
  "threads.totalStarted": 21,
  "threads": 17,
  "classes": 6912,
  "classes.loaded": 6912,
  "classes.unloaded": 0,
  "gc.ps_scavenge.count": 10,
  "gc.ps_scavenge.time": 225,
  "gc.ps_marksweep.count": 2,
  "gc.ps_marksweep.time": 274,
  "httpsessions.max": -1,
  "httpsessions.active": 0,
  "gauge.response.chat.message.id": 541.0,
  "gauge.response.chat.new": 2459.0,
  "gauge.response.health": 37.0,
  "counter.status.200.chat.new": 1,
  "counter.status.200.chat.message.id": 1,
  "counter.status.200.health": 1
}

 http://localhost:8080/health :
 
 {
  "status": "UP",
  "diskSpace": {
    "status": "UP",
    "total": 499248103424,
    "free": 46454468608,
    "threshold": 10485760
  },
  "mongo": {
    "status": "UP",
    "version": "3.0.3"
  }
}


 http://localhost:8080/info :
 
 {}
 
 http://localhost:8080/trace :
 [
  {
    "timestamp": 1467564077806,
    "info": {
      "method": "GET",
      "path": "/info",
      "headers": {
        "request": {
          "host": "localhost:8080",
          "connection": "keep-alive",
          "upgrade-insecure-requests": "1",
          "user-agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36",
          "accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
          "accept-encoding": "gzip, deflate, sdch",
          "accept-language": "en-US,en;q=0.8"
        },
        "response": {
          "X-Application-Context": "application",
          "Content-Type": "application/json;charset=UTF-8",
          "Transfer-Encoding": "chunked",
          "Date": "Sun, 03 Jul 2016 16:41:17 GMT",
          "status": "200"
        }
      }
    }
  },
  {
    "timestamp": 1467564034987,
    "info": {
      "method": "GET",
      "path": "/metrics",
      "headers": {
        "request": {
          "host": "localhost:8080",
          "connection": "keep-alive",
          "upgrade-insecure-requests": "1",
          "user-agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36",
          "accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
          "accept-encoding": "gzip, deflate, sdch",
          "accept-language": "en-US,en;q=0.8"
        },
        "response": {
          "X-Application-Context": "application",
          "Content-Type": "application/json;charset=UTF-8",
          "Transfer-Encoding": "chunked",
          "Date": "Sun, 03 Jul 2016 16:40:34 GMT",
          "status": "200"
        }
      }
    }
  },
  {
    "timestamp": 1467563995100,
    "info": {
      "method": "GET",
      "path": "/health",
      "headers": {
        "request": {
          "host": "localhost:8080",
          "connection": "keep-alive",
          "upgrade-insecure-requests": "1",
          "user-agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36",
          "accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
          "accept-encoding": "gzip, deflate, sdch",
          "accept-language": "en-US,en;q=0.8"
        },
        "response": {
          "X-Application-Context": "application",
          "Content-Type": "application/json;charset=UTF-8",
          "Transfer-Encoding": "chunked",
          "Date": "Sun, 03 Jul 2016 16:39:55 GMT",
          "status": "200"
        }
      }
    }
  },
  {
    "timestamp": 1467563618219,
    "info": {
      "method": "POST",
      "path": "/chat/new",
      "headers": {
        "request": {
          "host": "localhost:8080",
          "connection": "keep-alive",
          "content-length": "161",
          "cache-control": "no-cache",
          "origin": "chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop",
          "content-type": "application/json",
          "user-agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36",
          "postman-token": "0672fa9d-2f93-9a49-f1a4-26ed65fdaff6",
          "accept": "*/*",
          "accept-encoding": "gzip, deflate",
          "accept-language": "en-US,en;q=0.8"
        },
        "response": {
          "X-Application-Context": "application",
          "Content-Type": "application/json;charset=UTF-8",
          "Transfer-Encoding": "chunked",
          "Date": "Sun, 03 Jul 2016 16:33:38 GMT",
          "status": "200"
        }
      }
    }
  },
  {
    "timestamp": 1467563604989,
    "info": {
      "method": "POST",
      "path": "/chat/message/5",
      "headers": {
        "request": {
          "host": "localhost:8080",
          "connection": "keep-alive",
          "content-length": "109",
          "cache-control": "no-cache",
          "origin": "chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop",
          "content-type": "application/json",
          "user-agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36",
          "postman-token": "1345d364-1250-2ff1-04b7-eb8a49368585",
          "accept": "*/*",
          "accept-encoding": "gzip, deflate",
          "accept-language": "en-US,en;q=0.8"
        },
        "response": {
          "X-Application-Context": "application",
          "status": "200"
        }
      }
    }
  }
]

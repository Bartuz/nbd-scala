#!/usr/bin/env python

from datetime import datetime
import string
import riak

riak = riak.RiakClient(pb_port=8087, protocol='pbc')
student = {'indeks': 's12539', 'name': 'Filip' }

bucket = riak.bucket('z8')

db_stud = bucket.new(student['indeks'], data=student).store()
print("Student saved. key=" + db_stud.key + ", data=" + str(db_stud.data))

db_stud_fetched = bucket.get(db_stud.key)
print("Fetched student(#" + db_stud_fetched.key + "). data=" + str(db_stud_fetched.data))

fetched_data = db_stud_fetched.data
fetched_data['surname'] = 'Bartuzi'
db_stud_fetched.data = fetched_data
db_stud_fetched.store()

db_stud_fetched = bucket.get(db_stud.key)
print("Fetched student (again, #" + db_stud_fetched.key + "). data=" + str(db_stud_fetched.data))

bucket.delete(db_stud_fetched.key)

print("Fetching deleted student(#" + db_stud_fetched.key + ". data=" + str(bucket.get(db_stud_fetched.key).data))

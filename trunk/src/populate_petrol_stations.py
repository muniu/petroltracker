stations = open("/home/saidimu/workspace/petroltracker/svn_ignored/misc/stations/nairobi.list.txt")

for line in stations:
    tokens = line.split(",")
    canonical_name = tokens[0].strip() + tokens[1].strip()
    canonical_name = tokens[0].strip() + " (" + tokens[1].strip() + ")"
    lat = float(tokens[2])
    lon = float(tokens[3])
    geopt=db.GeoPt(lat, lon)
    ps = PetrolStation(canonical_name=canonical_name,location=geopt)
    ps.update_location()
    ps.put()


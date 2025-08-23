
def solution3(genres, plays):
    album = dict()
    genres_priority = []
    idx = 0
    for genere, play in zip(genres, plays):
        if genere in album:
            album[genere].append({'idx':idx, 'play':play})
            album[genere][0]['max'] += play
        else:
            album[genere] = [{'max':play, 'play':-1}, {'idx':idx, 'play':play}]

    for key in album.keys():
        album[key].sort(key=lambda x:x['play'], reverse=True)

    print(album)
    answer = []
    return answer
